package eao;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;



import entidades.EntidadBase;
import excepciones.EntidadBaseException;
@Stateless
public abstract class EAOManagerImpl<E> implements EAOManager<E> {
	@PersistenceContext(unitName="ejbModule")
	protected EntityManager em;
	protected EntityManagerFactory emf;	
	/**
	 * Busca en la unidad de persistencia un objeto dado su ID.
	 * @return La entidad correspondiente. 
	 * @param el id del objeto a buscar.
	 */
	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public E buscar(Object id) throws EntidadBaseException  {
		E encontrado = em.find(this.getClase(), id);
		
		if (encontrado != null)	{
			
			return encontrado;	
		}		
		throw new EntidadBaseException("ERROR: Objeto no encontrado");	
	}
	/**
	 * edita(merge) una entidad dada,  la entidad debe de tener seteado el ID 
	 * de lo contrario crea una nueva entidad. 
	 * @param Entidad a editar.
	 */
	public void guardar_editado(E entidad) throws EntidadBaseException{
		try {
			if (entidad != null) {
				em.merge(entidad);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new EntidadBaseException("ERROR: Objeto no guardado. " + e.getMessage());	
		}		
	}
	/**
	 * elimina el registro de la tabla definida 
	 * por el facade al cual pertenece.
	 * @param ID de la entidad a eliminar.
	 */
	@Override
	public void eliminar(Object id) throws EntidadBaseException{	
		E e = this.buscar(id);
		try {
			em.remove(e);	
		} catch (Exception e2) {
			// TODO: handle exception
			throw new EntidadBaseException("ERROR: Objeto no eliminado. " + e2.getMessage());
		}
		
	}
	/**
	 * Elimina una lista de entidades de la unidad de persistencia
	 * @param Listado con Entidades a eliminar.
	 */
	@Override
	public void eliminar(List<E> entidad) throws EntidadBaseException{		
		try {
			
			for (E e : entidad) {			
				if (e != null) {
					em.remove(e);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new EntidadBaseException("ERROR: Objetos no eliminados. " + e.getMessage());
		}
		
	}	
	/**
	 * persiste la entidad dada
	 * @entity la entidad a persistir.
	 */
	public void guardar_nuevo(E entity) throws EntidadBaseException{	
		try {
			if (entity != null) {
				em.persist(entity);
			}	
		} catch (Exception e) {
			// TODO: handle exception
			throw new EntidadBaseException("ERROR: Objeto no guardado. " + e.getMessage());
		}
		
	}
	/**
	 * Inserta/Edita una entidad dependiendo de si existe o no en la Base de datos.
	 * @return La entidad correspondiente. 
	 * @param el id del objeto a buscar.
	 */
	@Override
	public void guardar(E entidad) throws EntidadBaseException {
		
		try {			
			Object id = ((EntidadBase) entidad).getPK();
			
			if (id==null){			
				guardar_nuevo(entidad);			
			}else{
				@SuppressWarnings("unused")
				E existe = buscar(id);
				guardar_editado(entidad);						
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new EntidadBaseException("ERROR: Objeto no guardado. " + e.getMessage());
		}
	}	

	
	/**
	 * Lista los elementos filtrados por el objeto con atributos de filtro seteados,
	 * PARA UTILIZAR ESTE METODO LOS ATRIBUTOS DE LA ENTIDAD DEBEN CLASES ENVOLTORIO, NO PRIMITIVOS
	 * ej: para int->Integer
	 * @param e La entidad que se utiliza como filtro, null para listar todos
	 * @param orden nombre del atributo con el cual realizar un orden by en la consulta. null en caso de no desear orden
	 * @return la lista de los objetos filtrados.
	 */
	@Override
	public List<E> listar(E e, String orden) throws EntidadBaseException{
//		emf = Persistence.createEntityManagerFactory("ejbModule");		
		
		try {
		
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(this.getClase());
		Root<E> root = cq.from(this.getClase());
		
		if(e!=null){
			List<Predicate> predicado = new ArrayList<Predicate>();
			Field[] fields = this.getClase().getDeclaredFields();
			for(int i=0; i < fields.length; i++){
				Object propiedad = getPropiedad(e, fields[i].getName());
				if(propiedad !=null){
					if (esEntidad(propiedad)){
						String idEntity = getID(propiedad);
						if (idEntity != null){
							predicado.add(cb.equal(root.<EntidadBase>get(fields[i].getName()),getPropiedad((E)propiedad,idEntity)));
						}
					}else{
						predicado.add(cb.equal(root.get(fields[i].getName()),propiedad));
					}
				}
			}
			if(predicado.size()!=0){
				cq.where(cb.and(predicado.toArray(new Predicate[0])));
			}
		}		
		cq.select(root);
		if(!"".equals(orden)){
			cq.orderBy(cb.asc(root.get(orden)));
		}
		//ejecuta la consulta y obtiene la lista
		List<E> list = em.createQuery(cq).getResultList();
		//variable de retorno ordenada.
		return list;
		
		} catch (Exception e2) {
			// TODO: handle exception
			throw new EntidadBaseException("ERROR: No se puede listar. " + e2.getMessage());
		}	
		
	}
	
	private String getID(Object propiedad) {
			Field[] fields = propiedad.getClass().getDeclaredFields();
			for(int i=0; i < fields.length; i++){
			Annotation[] annotations = fields[i].getAnnotations();
				for (int j=0; j < annotations.length; j++) {
					if (annotations[j].toString().contains("javax.persistence.Id")){
						return fields[i].getName().toString();
					}
				}
			}
			return null;		
		}
	private boolean esEntidad(Object objeto){

			Annotation[] a = objeto.getClass().getAnnotations();
			for (int j = 0; j < a.length; j++){
			if (a[j].toString().contains("javax.persistence.Entity"))
				return true;
			}
			return false;			
		}
	public Object getPropiedad(E e, String nombrePropiedad){
		if(nombrePropiedad == null || nombrePropiedad.length() < 1){
			return null;
		}
		
		
		String nombreMetodo = "get" +
		nombrePropiedad.substring(0,1).toUpperCase() +
		nombrePropiedad.substring(1);
		
		Object ejecutarPropiedad = null;
		try {
			Method m = e.getClass().getMethod(nombreMetodo, null);
			ejecutarPropiedad = m.invoke(e, null);
		} catch (Exception e2) {
			// TODO: handle exception
			return null;
		}
		return ejecutarPropiedad;
	}
	private Class<E> getClase(){
		ParameterizedType parametro = (ParameterizedType) this.getClass().getGenericSuperclass();
		return((Class<E>)parametro.getActualTypeArguments()[0]);
	}

}

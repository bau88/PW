package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eao.EAOManager;
import entidades.Caja;
import entidades.Cliente;
import entidades.Compra;
import entidades.CompraDetalle;
import entidades.EntidadBase;
import entidades.Factura;
import entidades.FacturaDetalle;
import entidades.Pago;
import entidades.Producto;
import entidades.Proveedor;
import entidades.Rol;
import entidades.RolUsuario;
import entidades.Usuario;
import facade.CajaFacadeLocal;
import facade.ClienteFacadeLocal;
import facade.CompraFacadeLocal;
import facade.FacturaFacadeLocal;
import facade.PagoFacadeLocal;
import facade.ProductoFacadeLocal;
import facade.ProveedorFacadeLocal;
import facade.RolFacade;
import facade.RolFacadeLocal;
import facade.RolUsuarioFacadeLocal;
import facade.UsuarioFacadeLocal;

/**  
 * Servlet implementation class pruebas
 */
public class pruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(beanInterface=ProductoFacadeLocal.class,mappedName="ProductoFacade/local")
	ProductoFacadeLocal productoFacade;
	@EJB(beanInterface=ProveedorFacadeLocal.class,mappedName="ProveedorFacade/local")
	ProveedorFacadeLocal proveedorFacade;   
	@EJB(beanInterface=CajaFacadeLocal.class,mappedName="CajaFacade/local")
	CajaFacadeLocal cajaFacade;
	@EJB(beanInterface=UsuarioFacadeLocal.class,mappedName="UsuarioFacade/local")
	UsuarioFacadeLocal usuarioFacade;	
	@EJB(beanInterface=CompraFacadeLocal.class,mappedName="CompraFacade/local")
	CompraFacadeLocal compraFacade;   
	@EJB(beanInterface=RolFacadeLocal.class,mappedName="RolFacade/local")
	RolFacadeLocal rolFacade;
	@EJB(beanInterface=RolUsuarioFacadeLocal.class,mappedName="RolUsuarioFacade/local")
	RolUsuarioFacadeLocal rolUsuarioFacade;
	@EJB(beanInterface=FacturaFacadeLocal.class,mappedName="FacturaFacade/local")
	FacturaFacadeLocal facturaFacade;
	@EJB(beanInterface=ClienteFacadeLocal.class,mappedName="ClienteFacade/local")
	ClienteFacadeLocal clienteFacade;
	@EJB(beanInterface=PagoFacadeLocal.class,mappedName="PagoFacade/local")
	PagoFacadeLocal pagoFacade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesar(request, response);
	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter pw = response.getWriter();
		String op = request.getParameter("operacion");
		
		try {
			if ("guardar".equals(op)) {
				//compra
				/*
				Compra compra = new Compra();		
				Proveedor proveedor = new Proveedor();
				proveedor.setNombre("ElProveedor");
				
				List<Compra> lista = compraFacade.listar_remoto(compra, proveedor, "");
				
				for(Compra compras: lista){
					System.out.println(compras.getIdCompra());
				}	
				
				/*
				compra.setTotalCompra(100000);
				Proveedor p = proveedorFacade.buscar(1);
				compra.setProveedor(p);
				CompraDetalle detalle = new CompraDetalle(compra);
				List<CompraDetalle> lista = new ArrayList<CompraDetalle>();
				
				detalle.setProducto(productoFacade.buscar(2));
				detalle.setCantidad(10);
				detalle.setPrecioCompra(50);
				
				CompraDetalle detalle2 = new CompraDetalle(compra);
				detalle2.setProducto((Producto)productoFacade.buscar(4));
				detalle2.setCantidad(20);
				detalle2.setPrecioCompra(50);
								
				compra.setCompraDetalles(detalle);
				compra.setCompraDetalles(detalle2);
				
				
				compraFacade.guardar(compra); 
			//caja usuario rol
			/*	Caja caja = new Caja();
				caja.setDescripcion("caja 1");
				cajaFacade.guardar(caja);
				
				Rol rol = new Rol();
				rol.setNombre("Rol 1");
				
				rolFacade.guardar(rol);				
				
				Usuario usuario = new Usuario();
				usuario.setNombre("sheldon");
				usuario.setAlias("shell");
				usuario.setContrasenha("master");
				
				usuario.setCaja(cajaFacade.buscar(1));
//				usuario.setRol(rolFacade.buscar(1));
				
				
				
				usuarioFacade.guardar(usuario);				
				rolUsuarioFacade.guardar(new RolUsuario(usuario, rol));*/
				// VENTAS
				//cabecera
				/*
				Factura factura = new Factura();
				Cliente cliente = new Cliente();
				cliente.setNombre("Novako");
				
				facturaFacade.lis
				factura.setCliente(cliente);
				factura.setFecha(new Date());
				factura.setNumero("09993-0");
				//detalle
				
				FacturaDetalle detalle  = new FacturaDetalle(factura);
				detalle.setCantidad(1);
				Producto producto = productoFacade.buscar(2);				
				detalle.setProducto(producto);				
				detalle.setPrecioVenta(productoFacade.getPrecioVenta(producto));
				
				FacturaDetalle detalle2  = new FacturaDetalle(factura);
				detalle2.setCantidad(1);
				Producto producto2 = productoFacade.buscar(4);				
				detalle2.setProducto(producto2);				
				detalle2.setPrecioVenta(productoFacade.getPrecioVenta(producto2));
				
				factura.setFacturaDetalles(detalle);
				factura.setFacturaDetalles(detalle2);
				
				facturaFacade.guardar(factura);
				//PAGO DE FACTURA*/
				Caja caja = new Caja();
				caja.setIdCaja(2);
				
				/*
				
				Pago pago = new Pago(cajaFacade.buscar(1), facturaFacade.buscar(20));		
				pago.setMonto(100);
				*/
				pagoFacade.CierreCaja(caja);
				
				pw.println("Venta guardado exitosamente");
			} 
			else 
			
				if ("modificar".equals(op)) {
					Producto producto = (Producto)productoFacade.buscar(new Integer(2));
					producto.setDescripcion("manzana");												
					
					productoFacade.guardar(producto);
					
					pw.println("Producto modificado exitosamente");
				}
				else
					if ("eliminar".equals(op)) {
																			
						/*
						productoFacade.eliminar(new Integer(1));
						
						pw.println("Producto borrado exitosamente");*/
						//eliminar compra						
						//compraFacade.eliminar(8);
						//eliminar venta
						facturaFacade.eliminar(19);
					}
					else
						if ("listar".equals(op)) {
							Producto producto = new Producto();							
							List<Producto> lista = productoFacade.listar(producto,null);
							String lista_clientes = "";
							for(EntidadBase item : lista){
								Cliente uncliente = (Cliente) item;
								lista_clientes+= uncliente.getNombre() + ", ";
							}
							
						
							
							
							pw.println("Cliente listado exitosamente" + lista_clientes);
							
						}
						else{
							if ("aumentar".equals(op)) {
								Producto producto = (Producto)productoFacade.buscar(new Integer(2));																		
								
								productoFacade.guardar(productoFacade.stockAumenta(producto, 10));
								
								pw.println("Producto aumentado exitosamente");
								
							}	
							else{
								if ("disminuir".equals(op)) {
									Producto producto = (Producto)productoFacade.buscar(new Integer(2));																		
									
									
									productoFacade.guardar(productoFacade.stockDisminuye(producto, 5));
									
									pw.println("Producto aumentado exitosamente");
									
								}	
							}
						
						}
				
			pw.flush();
			pw.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesar(request, response);
	}

}

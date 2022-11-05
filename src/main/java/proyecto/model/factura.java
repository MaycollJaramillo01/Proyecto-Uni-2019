package proyecto.model;



import java.sql.Date;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="factura")
public class factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID_FACTURA  ;
	
	@Column(name = "FECHA", nullable = false)
	private Date FECHA;
	
	@Column(name = "CLIENTE", nullable = false)
	private String CLIENTE;
	
	@Column(name = "TOTAL", nullable = false)
	private String TOTAL;

	public long getID_FACTURA() {
		return ID_FACTURA;
	}

	public void setID_FACTURA(long ID_FACTURA) {
		this.ID_FACTURA = ID_FACTURA;
	}

	public Date getFECHA() {
		return FECHA;
	}

	public void setFECHA(Date FECHA) {
		this.FECHA = FECHA;
	}

	public String getCLIENTE() {
		return CLIENTE;
	}

	public void setCLIENTE(String CLIENTE) {
		this.CLIENTE = CLIENTE;
	}

	public String getTOTAL() {
		return TOTAL;
	}

	public void setTOTAL(String TOTAL) {
		this.TOTAL = TOTAL;
	}

	
}

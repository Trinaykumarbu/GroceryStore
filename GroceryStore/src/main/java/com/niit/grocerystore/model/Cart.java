package com.niit.grocerystore.model;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Cart {
	@Id

	private String ctId;
	private Double ctGrandtotal=0.0;
	private int ctTotalitem=0;
	
	@OneToMany(mappedBy="cart")
	private List<CartItems> cartItems;
	
	public Cart()
	{
		this.ctId="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public List<CartItems> getCartItems() {
		return cartItems;
	}
	public String getCtId() {
		return ctId;
	}
	public void setCtId(String ctId) {
		this.ctId = ctId;
	}
		public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

		public Double getCtGrandtotal() {
			return ctGrandtotal;
		}

		public void setCtGrandtotal(Double ctGrandtotal) {
			this.ctGrandtotal = ctGrandtotal;
		}

		public int getCtTotalitem() {
			return ctTotalitem;
		}

		public void setCtTotalitem(int ctTotalitem) {
			this.ctTotalitem = ctTotalitem;
		}
	
}

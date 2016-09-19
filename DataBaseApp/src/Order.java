/**
 * @author Eduard Ulasenka, 273173
 */

public class Order {

	private int order_id;
	private int tourist_id;
	private String order_date;
	private int amount;
	
	public Order(int order_id, int tourist_id, String order_date, int amount) {
		super();
		this.order_id = order_id;
		this.tourist_id = tourist_id;
		this.order_date = order_date;
		this.amount = amount;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getTourist_id() {
		return tourist_id;
	}

	public void setTourist_id(int tourist_id) {
		this.tourist_id = tourist_id;
	}

	public String getDate() {
		return order_date;
	}

	public void setDate(String date) {
		this.order_date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String
				.format("Order [order_id=%s, tourist_id=%s, order_date=%s, amount=%s",
						order_id, tourist_id, order_date, amount);
	}
	
	
		
}
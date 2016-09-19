/**
 * @author Eduard Ulasenka, 273173
 */

public class Tourist {
	private int tourist_id;
	private String name;
	private String surame;
	private int clubcard_id;
	private int address_id;
	
	public Tourist(int tourist_id, String name, String surame, int clubcard_id, int address_id) {
		super();
		this.tourist_id = tourist_id;
		this.name = name;
		this.surame = surame;
		this.clubcard_id = clubcard_id;
		this.address_id = address_id;
	}

	public int getTourist_id() {
		return tourist_id;
	}

	public void setTourist_id(int tourist_id) {
		this.tourist_id = tourist_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surame;
	}

	public void SetSurname(String surame) {
		this.surame = surame;
	}

	public int getAddress() {
		return clubcard_id;
	}

	public void setAddress(int clubcard_id) {
		this.clubcard_id = clubcard_id;
	}
	
	public int getClubCard() {
		return address_id;
	}

	public void setClubCard(int address_id) {
		this.address_id = address_id;
	}

	@Override
	public String toString() {
		return String
				.format("Tourist [tourist_id=%s, name=%s, surame=%s, clubcard_id=%s, address_id=%s",
						tourist_id, name, surame, clubcard_id, address_id);
	}
	
	
		
}
package com.stkprojects.easycontacts.model;

public class Address {

    private long id;
    private long contact_id;
    private String address_line_1;
    private String address_line_2;
    private String city;
    private String state;
    private String pin_or_zip_code;
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContact_id() {
        return contact_id;
    }

    public void setContact_id(long contact_id) {
        this.contact_id = contact_id;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin_or_zip_code() {
        return pin_or_zip_code;
    }

    public void setPin_or_zip_code(String pin_or_zip_code) {
        this.pin_or_zip_code = pin_or_zip_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address_line_1 == null) ? 0 : address_line_1.hashCode());
		result = prime * result + ((address_line_2 == null) ? 0 : address_line_2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (contact_id ^ (contact_id >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pin_or_zip_code == null) ? 0 : pin_or_zip_code.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address_line_1 == null) {
			if (other.address_line_1 != null)
				return false;
		} else if (!address_line_1.equals(other.address_line_1))
			return false;
		if (address_line_2 == null) {
			if (other.address_line_2 != null)
				return false;
		} else if (!address_line_2.equals(other.address_line_2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contact_id != other.contact_id)
			return false;
		if (id != other.id)
			return false;
		if (pin_or_zip_code == null) {
			if (other.pin_or_zip_code != null)
				return false;
		} else if (!pin_or_zip_code.equals(other.pin_or_zip_code))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
    
}

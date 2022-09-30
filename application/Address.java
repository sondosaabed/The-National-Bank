package application;

/* 
    Adress table 
*/

public class Address {
    private int primaryKey;
    private int Postal_code;
    private String name;
    private String StreetName;



    public Address() {
        super();
    }
    public Address(int postal_code, String name, String streetName) {
        this.name = name;
        StreetName = streetName;
        Postal_code = postal_code;
    }

    public Address(int primaryKey, int postal_code, String name, String streetName) {
        this.primaryKey = primaryKey;
        this.name = name;
        StreetName = streetName;
        Postal_code = postal_code;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public int getPostal_code() {
        return Postal_code;
    }

    public void setPostal_code(int postal_code) {
        Postal_code = postal_code;
    }
}

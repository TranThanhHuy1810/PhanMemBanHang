package Model;

public class ComboItem {
    private String value;
    private String display;

   


	public ComboItem(String value2, String display2) {
		 this.value = value2;
	        this.display = display2;
	}


	public String getValue() {
        return value;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return display; // Để hiển thị đúng trên JComboBox
    }
}

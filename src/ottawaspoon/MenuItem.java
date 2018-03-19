public class MenuItem {

    private int itemID;
    private String name;
    private String type;
    private String category;
    private String description;
    private int price;
    private int restaurantID;

    public MenuItem() {
    }

    public MenuItem(int itemID, String name, String type, String category, String description, int price, int restaurantID) {
        this.itemID = itemID;
        this.name = name;
        this.type = type;
        this.category = category;
        this.description = description;
        this.price = price;
        this.restaurantID = restaurantID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }
}

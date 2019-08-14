package wap.news.model;


public class Category {

    private int id;
    private String name;
    private Boolean isActive;

    public Category(String name,boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public Category(int id, String name, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}

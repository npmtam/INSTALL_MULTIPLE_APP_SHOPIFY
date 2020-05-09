package commons;

public class StoresLink {
    private String url;
    private String store_type;
    private String email;
    private String storeName;

    public StoresLink(String url, String email, String storeName, String store_type) {
        super();
        this.url = url;
        this.email = email;
        this.storeName = storeName;
        this.store_type = store_type;
    }

    @Override
    public String toString() {
        return url + ", " + email + ", " + storeName + ", " + store_type;
    }

    public String getUrl() {
        return url;
    }

    public String getStore_type() {
        return store_type;
    }

    public String getEmail() {
        return email;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStore_type(String store_type) {
        this.store_type = store_type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}

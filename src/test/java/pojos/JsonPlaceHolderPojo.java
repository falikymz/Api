package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {
   // NOT:
   // @JsonIgnoreProperties(ignoreUnknown = true) annotasyonu, JSON verisindeki bilinmeyen alanları yoksaymak için kullanılır.
   // Bu annotasyon, Java sınıfındaki alanlarla eşleşmeyen veya bilinmeyen JSON alanlarını görmezden gelir.
    /*
    POJO: "Plain Old Java Object"
        : Mükemmel bir şablon örneğidir
    4 Adımda oluşturulur;
     1) "private" değişkenler tanımlanır
     2) "consturctor"lar üretilir (parametresiz ve tüm parametreli)
     3) "getter" and "setter" methodlar oluşturulur
     4) "toString" method oluşturulur
     */

    // 1) "private" değişkenler tanımlanır
    private Integer userId;
    private String title;
    private Boolean completed;

    // 2) "consturctor"lar üretilir (parametresiz ve tüm parametreli)
    public JsonPlaceHolderPojo() {
    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    // 3) "getter" and "setter" methodlar oluşturulur
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // 4) "toString" method oluşturulur
    @Override
    public String toString() {
        return "{" +
                "[]userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

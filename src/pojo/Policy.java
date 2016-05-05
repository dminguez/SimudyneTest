package pojo;

public class Policy {

    public static final String BREED_C = "Breed_C";
    public static final String BREED_NC = "Breed_NC";

    private Long id;
    private String breed;
    private Integer age;
    private Integer socialGrade;
    private Integer paymentAtPurchase;
    private Double brand;
    private Double price;
    private Double promotions;
    private Boolean autoRenew;
    private Integer inertiaForSwitch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSocialGrade() {
        return socialGrade;
    }

    public void setSocialGrade(Integer socialGrade) {
        this.socialGrade = socialGrade;
    }

    public Integer getPaymentAtPurchase() {
        return paymentAtPurchase;
    }

    public void setPaymentAtPurchase(Integer paymentAtPurchase) {
        this.paymentAtPurchase = paymentAtPurchase;
    }

    public Double getBrand() {
        return brand;
    }

    public void setBrand(Double brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPromotions() {
        return promotions;
    }

    public void setPromotions(Double promotions) {
        this.promotions = promotions;
    }

    public Boolean getAutoRenew() {
        return autoRenew;
    }

    public void setAutoRenew(Integer autoRenew) {
        this.autoRenew = autoRenew == 0 ? false : true;
    }

    public Integer getInertiaForSwitch() {
        return inertiaForSwitch;
    }

    public void setInertiaForSwitch(Integer inertiaForSwitch) {
        this.inertiaForSwitch = inertiaForSwitch;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(getBreed()).append(",");
        output.append(getId()).append(",");
        output.append(getAge()).append(",");
        output.append(getSocialGrade()).append(",");
        output.append(getPaymentAtPurchase()).append(",");
        output.append(getBrand()).append(",");
        output.append(getPrice()).append(",");
        output.append(getPromotions()).append(",");
        output.append(getAutoRenew() ? "1" : "0").append(",");
        output.append(getInertiaForSwitch());

        return output.toString();
    }
}

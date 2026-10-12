package model;

public class PromoCode {

    private final String code;
    private final double discountPercent;

    public PromoCode(String code, double discountPercent) {
        this.code = code;

        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException(
                    "Скидка должна быть от 0 до 100%"
            );
        }

        this.discountPercent = discountPercent;
    }

    public String getCode() {
        return code;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }
}

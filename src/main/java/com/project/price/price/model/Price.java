package com.project.price.price.model;

import com.project.price.price.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICES")
public class Price implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull(message = "This field must not be null")
    @Column(name = "start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @NotNull(message = "This field must not be null")
    @Column(name = "end_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @NotNull(message = "This field must not be null")
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @NotNull(message = "This field must not be null")
    @Column(nullable = false)
    private Integer priority;

    @NotNull(message = "This field must not be null")
    @DecimalMin(value = "0.0", message = "The value must be greater than 0")
    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 5)
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(id, price1.id) && Objects.equals(startDate, price1.startDate) && Objects.equals(endDate, price1.endDate) && Objects.equals(productId, price1.productId) && Objects.equals(priority, price1.priority) && Objects.equals(price, price1.price) && currency == price1.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, productId, priority, price, currency);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", productId=" + productId +
                ", priority=" + priority +
                ", price=" + price +
                ", currency=" + currency +
                '}';
    }
}

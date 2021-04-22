package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchFilter {
    private String priceRange;
    private String availability;
    private String language;
    private String format;
}

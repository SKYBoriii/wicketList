package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WishListDTO {

    private Long id;
    private int wishPrice;
    private String wishItem;

    public WishListDTO(Long id, int wishPrice, String wishItem) {
        this.id = id;
        this.wishPrice = wishPrice;
        this.wishItem = wishItem;
    }


}

package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeWishListContentDTO {

    private Long id;
    private int wishPrice;
    private String wishItem;

    public ChangeWishListContentDTO(Long id, int wishPrice, String wishItem ) {
        this.id = id;
        this.wishItem = wishItem;
        this.wishPrice = wishPrice;
    }
}

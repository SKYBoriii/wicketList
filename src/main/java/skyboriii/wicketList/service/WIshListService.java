package skyboriii.wicketList.service;

import skyboriii.wicketList.data.dto.WishListDTO;

public interface WIshListService {

    WishListDTO getWishList(Long id);

    WishListDTO saveWishList(WishListDTO wishListDTO);

    WishListDTO changeWishListItem(Long id, String item, int price) throws Exception;

    void deleteWishList(Long id) throws Exception;
}

package skyboriii.wicketList.service;

import skyboriii.wicketList.data.dto.WIshListDTO;
import skyboriii.wicketList.data.dto.WishListResponseDTO;

public interface WIshListService {

    WishListResponseDTO getWishList(Long id);

    WishListResponseDTO saveWishList(WIshListDTO wIshListDTO);

    WishListResponseDTO changeWishListContent(Long id, String content) throws Exception;

    void deleteWishList(Long id) throws Exception;
}

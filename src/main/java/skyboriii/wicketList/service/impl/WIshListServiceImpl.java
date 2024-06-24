package skyboriii.wicketList.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skyboriii.wicketList.data.dao.WishDAO;
import skyboriii.wicketList.data.dto.WishListDTO;
import skyboriii.wicketList.entity.WishList;
import skyboriii.wicketList.service.WIshListService;

@Service
public class WIshListServiceImpl implements WIshListService {

    private final WishDAO wishDAO;

    @Autowired
    public WIshListServiceImpl(WishDAO wishDAO) {
        this.wishDAO = wishDAO;
    }

    @Override
    public WishListDTO getWishList(Long id) {
        WishList wishList = wishDAO.selectWish(id);

        WishListDTO wishListDTO
                 = new WishListDTO();

        wishListDTO.setWishItem(wishList.getWishItem());
        wishListDTO.setWishPrice(wishList.getWishPrice());
        wishListDTO.setId(wishList.getWishId());

        return wishListDTO;
    }

    @Override
    public WishListDTO saveWishList(WishListDTO wishListDTO) {
        WishList wishList = new WishList();

        wishList.setWishItem(wishListDTO.getWishItem());
        wishList.setWishPrice(wishListDTO.getWishPrice());
        //

        WishList savedWishList = wishDAO.insertWish(wishList);

        WishListDTO wishListResponseDTO = new WishListDTO();

        wishListResponseDTO.setWishPrice(savedWishList.getWishPrice());
        wishListResponseDTO.setWishItem(savedWishList.getWishItem());

        return wishListResponseDTO;
    }

    @Override
    public WishListDTO changeWishListItem(Long id, String content, int price) throws Exception {
        WishList changeWishList = wishDAO.updateWishContent(id, content, price);

        WishListDTO wishListDTO = new WishListDTO();
        wishListDTO.setWishItem(changeWishList.getWishItem());
        wishListDTO.setWishPrice(changeWishList.getWishPrice());
        //

        return wishListDTO;
    }

    @Override
    public void deleteWishList(Long id) throws Exception{
        wishDAO.deleteWish(id);

    }
}

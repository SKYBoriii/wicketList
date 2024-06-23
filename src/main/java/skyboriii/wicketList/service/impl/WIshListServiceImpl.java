package skyboriii.wicketList.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skyboriii.wicketList.data.dao.WishDAO;
import skyboriii.wicketList.data.dto.WIshListDTO;
import skyboriii.wicketList.data.dto.WishListResponseDTO;
import skyboriii.wicketList.entity.WishList;
import skyboriii.wicketList.service.WIshListService;

import java.time.LocalDateTime;

@Service
public class WIshListServiceImpl implements WIshListService {

    private final WishDAO wishDAO;

    @Autowired
    public WIshListServiceImpl(WishDAO wishDAO) {
        this.wishDAO = wishDAO;
    }

    @Override
    public WishListResponseDTO getWishList(Long id) {
        WishList wishList = wishDAO.selectWish(id);

        WishListResponseDTO wishListResponseDTO
                 = new WishListResponseDTO();

        wishListResponseDTO.setWishContent(wishList.getWishContent());
        wishListResponseDTO.setWishWriter(wishList.getWishWriter());
        wishListResponseDTO.setId(wishList.getWishId());

        return wishListResponseDTO;
    }

    @Override
    public WishListResponseDTO saveWishList(WIshListDTO wIshListDTO) {
        WishList wishList = new WishList();

        wishList.setWishContent(wIshListDTO.getWishContent());
        wishList.setWishWriter(wIshListDTO.getWishWriter());
        wishList.setWishCreatedAt(LocalDateTime.now());
        wishList.setWishUpdatedAt(LocalDateTime.now());

        WishList savedWishList = wishDAO.insertWish(wishList);

        WishListResponseDTO wishListResponseDTO = new WishListResponseDTO();

        wishListResponseDTO.setWishWriter(savedWishList.getWishWriter());
        wishListResponseDTO.setWishContent(savedWishList.getWishContent());

        return wishListResponseDTO;
    }

    @Override
    public WishListResponseDTO changeWishListContent(Long id, String content) throws Exception {
        WishList changeWishList = wishDAO.updateWishContent(id, content);

        WishListResponseDTO wishListResponseDTO = new WishListResponseDTO();
        wishListResponseDTO.setWishContent(changeWishList.getWishContent());
        wishListResponseDTO.setWishWriter(changeWishList.getWishWriter());

        return wishListResponseDTO;
    }

    @Override
    public void deleteWishList(Long id) throws Exception{
        wishDAO.deleteWish(id);

    }
}

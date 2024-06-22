package skyboriii.wicketList.data.dao;

import skyboriii.wicketList.entity.WishList;

public interface WishDAO {

    WishList insertWish(WishList wishList);

    WishList selectWish(Long id);

    WishList updateWishContent(Long id, String wishContent) throws Exception;

    void deleteWish(Long id) throws Exception;



}

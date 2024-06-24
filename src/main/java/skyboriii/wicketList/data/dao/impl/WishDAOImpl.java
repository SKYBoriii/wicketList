package skyboriii.wicketList.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import skyboriii.wicketList.data.dao.WishDAO;
import skyboriii.wicketList.entity.WishList;
import skyboriii.wicketList.repository.WishListRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class WishDAOImpl implements WishDAO {

    // 스프링이 관리하는 객체를 빈이라고 하는데 빈으로 등록된
    // 객체는 다른 클래스가 인터페이스를 가지고 의존성을 주입받을 떄 이 구현체를 찾아 주입하게 됩니다.
    private final WishListRepository wishListRepository;

    @Autowired
    public WishDAOImpl(WishListRepository wishListRepository){
        this.wishListRepository = wishListRepository;
    }


    @Override
    public WishList insertWish(WishList wishList) {
        WishList savedWishList = wishListRepository.save(wishList);

        return savedWishList;
    }

    @Override
    public WishList selectWish(Long id) {
        WishList selectedWishList = wishListRepository.getById(id);

        return selectedWishList;
    }

    // 업데이트를 할 때에는 영속성 컨테스트를 활용해 값을 갱신하는데, find() 메서드로 호출하면
    // 가져온 객체가 영속성 컨테스트에 추가됩니다.
    @Override
    public WishList updateWishContent(Long id, String wishItem, int price)
            throws Exception {
        Optional<WishList> selectedWishList = wishListRepository.findById(id);

        WishList updateWishList;

        if (selectedWishList.isPresent()) {
            WishList wishList = selectedWishList.get();

            wishList.setWishItem(wishItem);
            wishList.setWishPrice(price);

            updateWishList = wishListRepository.save(wishList);
        }
        else {
            throw new Exception();
        }

        return updateWishList;

    }

    // 삭제하기 위해서 update 처럼 영속 객체를 양속성 컨테스트에 가져와야 함.
    @Override
    public void deleteWish(Long id) throws Exception {
        Optional<WishList> selectedWishList = wishListRepository.findById(id);

        if (selectedWishList.isPresent()) {
            WishList wishList = selectedWishList.get();

            wishListRepository.delete(wishList);
        }
        else {
            throw new Exception();
        }

    }
}

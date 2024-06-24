package skyboriii.wicketList.data.dao.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import skyboriii.wicketList.data.dao.BucketDAO;
import skyboriii.wicketList.data.dto.BucketListDTO;
import skyboriii.wicketList.entity.BucketList;
import skyboriii.wicketList.repository.BucketListRepository;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Component

public class BucketDAOImpl implements BucketDAO {

    private final BucketListRepository bucketListRepository;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    public BucketDAOImpl(BucketListRepository bucketListRepository) {
        this.bucketListRepository = bucketListRepository;
    }


    @Override
    public BucketList insertBucket(BucketList bucketList) {
        BucketList savedBucketList = bucketListRepository.save(bucketList);

        return savedBucketList;
    }

    @Override
    public BucketList selectBucket(Long id) {
        BucketList selectedBucketList = bucketListRepository.getById(id);

        return selectedBucketList;
    }

    @Override
    public BucketList updateBucketContent(Long id, String bucketContent, String bucketGoal, String completedAt)
            throws Exception {
        Optional<BucketList> selectedBucketList = bucketListRepository.findById(id);

        BucketList updatedBucketList;
        if (selectedBucketList.isPresent()) {
            BucketList bucketList = selectedBucketList.get();

            Date date = formatter.parse(completedAt);

            bucketList.setBucketContent(bucketContent);
            bucketList.setBucketGoal(bucketGoal);
            bucketList.setCompletedAt(Instant.ofEpochMilli(date
                            .getTime())
                    .atZone(ZoneId.systemDefault()).toLocalDateTime());


            updatedBucketList = bucketListRepository.save(bucketList);
        } else {
            throw new Exception();
        }

        return updatedBucketList;
    }

    @Override
    public BucketList updateCompletedAt(Long id, String completedAt) throws Exception {
        Optional<BucketList> bucketList = bucketListRepository.findById(id);
        if (bucketList.isPresent()) {
            //yyyy/mm/dd
            // 시스템에 접근해서 날짜정보 가져옴
            Date date = formatter.parse(completedAt);
            bucketList.get().setCompletedAt(
                    Instant.ofEpochMilli(date
                                    .getTime())
                            .atZone(ZoneId.systemDefault()).toLocalDateTime());
            bucketListRepository.save(bucketList.get());
            return bucketList.get();
        } else {
            throw new Exception();
        }

    }


    @Override
    public void deleteBucket(Long id) throws Exception {
        Optional<BucketList> selectedBucketList = bucketListRepository.findById(id);

        if (selectedBucketList.isPresent()){
            BucketList bucketList = selectedBucketList.get();

            bucketListRepository.delete(bucketList);
        }
        else {
            throw new Exception();
        }
    }
}

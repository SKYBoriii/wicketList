package skyboriii.wicketList.service.impl;

import org.springframework.stereotype.Service;
import skyboriii.wicketList.data.dao.BucketDAO;
import skyboriii.wicketList.data.dto.BucketListDTO;
import skyboriii.wicketList.entity.BucketList;
import skyboriii.wicketList.service.BucketListService;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class BucketListServiceImpl implements BucketListService {

    private final BucketDAO bucketDAO;

    public BucketListServiceImpl(BucketDAO bucketDAO) {
        this.bucketDAO = bucketDAO;
    }

    @Override
    public BucketListDTO getBucketList(Long id) {
        BucketList bucketList = bucketDAO.selectBucket(id);

        BucketListDTO bucketListDTO = new BucketListDTO();

        bucketListDTO.setId(bucketList.getBucketId());
        bucketListDTO.setBucketGoal(bucketList.getBucketGoal());
        bucketListDTO.setBucketContent(bucketList.getBucketContent());

        return bucketListDTO;
    }

    @Override
    public BucketListDTO saveBucketList(BucketListDTO bucketListDTO) {
        BucketList bucketList = new BucketList();
        bucketList.setBucketContent(bucketListDTO.getBucketContent());
        bucketList.setBucketGoal(bucketListDTO.getBucketGoal());

        BucketList saveBucketList = bucketDAO.insertBucket(bucketList);

        BucketListDTO bucketListResponseDTO = new BucketListDTO();

        bucketListResponseDTO.setBucketContent(saveBucketList.getBucketContent());
        bucketListResponseDTO.setBucketGoal(saveBucketList.getBucketGoal());

        return bucketListResponseDTO;
    }

    @Override
    public BucketListDTO changeBucketListContent(Long id, String content, String goal, String completedAt) throws Exception {
        BucketList changeBucketList = bucketDAO.updateBucketContent(id, content, goal, completedAt);

        BucketListDTO bucketListDTO = new BucketListDTO();

        bucketListDTO.setBucketContent(changeBucketList.getBucketContent());
        bucketListDTO.setBucketGoal(changeBucketList.getBucketGoal());

        return bucketListDTO;
    }

    @Override
    public BucketListDTO completedBucketAt(Long id, String completedAt) throws Exception {
        BucketList bucketList = bucketDAO.updateCompletedAt(id,completedAt);
        BucketListDTO bucketListDTO = new BucketListDTO();
        bucketListDTO.setId(bucketList.getBucketId());
        bucketListDTO.setCompletedAt(bucketList.getCompletedAt().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        bucketListDTO.setBucketContent(bucketList.getBucketContent());
        bucketListDTO.setBucketGoal(bucketList.getBucketGoal());

        return bucketListDTO;
    }

    @Override
    public void deleteBucketList(Long id) throws Exception {
        bucketDAO.deleteBucket(id);
    }


}

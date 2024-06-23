package skyboriii.wicketList.service.impl;

import org.springframework.stereotype.Service;
import skyboriii.wicketList.data.dao.BucketDAO;
import skyboriii.wicketList.data.dto.BucketListDTO;
import skyboriii.wicketList.data.dto.BucketListResponseDTO;
import skyboriii.wicketList.entity.BucketList;
import skyboriii.wicketList.service.BucketListService;

import java.time.LocalDateTime;

@Service
public class BucketListServiceImpl implements BucketListService {

    private final BucketDAO bucketDAO;

    public BucketListServiceImpl(BucketDAO bucketDAO) {
        this.bucketDAO = bucketDAO;
    }

    @Override
    public BucketListResponseDTO getBucketList(Long id) {
        BucketList bucketList = bucketDAO.selectBucket(id);

        BucketListResponseDTO bucketListResponseDTO = new BucketListResponseDTO();

        bucketListResponseDTO.setId(bucketList.getBucketId());
        bucketListResponseDTO.setBucketWriter(bucketList.getBucketWriter());
        bucketListResponseDTO.setBucketContent(bucketList.getBucketContent());

        return bucketListResponseDTO;
    }

    @Override
    public BucketListResponseDTO saveBucketList(BucketListDTO bucketListDTO) {
        BucketList bucketList = new BucketList();
        bucketList.setBucketContent(bucketListDTO.getBucketContent());
        bucketList.setBucketWriter(bucketListDTO.getBucketWriter());
        bucketList.setBuketCreatedAt(LocalDateTime.now());
        bucketList.setBuketUpdatedAt(LocalDateTime.now());

        BucketList saveBucketList = bucketDAO.insertBucket(bucketList);

        BucketListResponseDTO bucketListResponseDTO = new BucketListResponseDTO();

        bucketListResponseDTO.setBucketContent(saveBucketList.getBucketContent());
        bucketListResponseDTO.setBucketWriter(saveBucketList.getBucketWriter());

        return bucketListResponseDTO;
    }

    @Override
    public BucketListResponseDTO changeBucketListContent(Long id, String content) throws Exception {
        BucketList changeBucketList = bucketDAO.updateBucketContent(id, content);

        BucketListResponseDTO bucketListResponseDTO = new BucketListResponseDTO();

        bucketListResponseDTO.setBucketContent(changeBucketList.getBucketContent());
        bucketListResponseDTO.setBucketWriter(changeBucketList.getBucketWriter());

        return bucketListResponseDTO;
    }

    @Override
    public void deleteBucketList(Long id) throws Exception {
        bucketDAO.deleteBucket(id);
    }
}

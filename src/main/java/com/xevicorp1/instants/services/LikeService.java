package com.xevicorp1.instants.services;

import com.xevicorp1.instants.dto.InstantRequestDto;
import com.xevicorp1.instants.dto.LikeRequestDto;
import com.xevicorp1.instants.models.Instant;
import com.xevicorp1.instants.models.Like;
import com.xevicorp1.instants.models.User;
import com.xevicorp1.instants.respositories.IInstantRepository;
import com.xevicorp1.instants.respositories.ILikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService implements ILikeService{
    private ILikeRepository likeRepository;
    private IInstantRepository instantRepository;

    public LikeService(ILikeRepository likeRepository, IInstantRepository instantRepository) {
        this.likeRepository = likeRepository;
        this.instantRepository = instantRepository;
    }

//    @Override
//    public Like create(LikeRequestDto likeRequest, User auth) {
//        var newLike = new Like();
//        newLike.setLover(auth);
//        return likeRepository.save(newLike);
//    }
//
//    @Override
//    public Like delete(Instant instant, User auth) {
//        var instantToDelete = instantRepository.findById(instant.getId()).get();
//        var likeToDelete = instantToDelete.getLikesList().stream().filter(like -> like.getLover() == auth);
//        likeRepository.delete(instantToDelete);
//        return Boolean false;
//    }

}

package com.example.demo.src.member;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.member.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

@Service
public class MemberService {

    private final MemberDao memberDao;

    @Autowired
    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    public GetMemberInfoRes findMemberInfoById(Long id) throws BaseException {
        try{
        GetMemberInfoRes findMember = memberDao.findMemberById(id);
        return findMember;
        }catch (Exception e){
            throw new BaseException(FAILED_TO_MEMBER);
        }
    }

    public List<GetMemberBadgeRes> findBadgeList(Long id) throws BaseException {
        try{
            List<GetMemberBadgeRes> findBadges = memberDao.findBadgeList(id);
            return  findBadges;
        }catch (Exception e){
            throw  new BaseException(FAILED_TO_BADGE);
        }
    }

    public int updateMember(PatchMemberReq updateMember) throws BaseException {
        try{
            return memberDao.updateMember(updateMember);
        }catch (Exception e){
            throw new BaseException(FAILED_TO_MEMBER);
        }
    }

    public List<GetMemberProduct> findProductList(long id) throws BaseException {
        try{
            return memberDao.findProductList(id);
        }catch (Exception e){
            throw new BaseException(FAILED_TO_PRODUCT);
        }
    }

    public int deleteMember(long id) throws BaseException {
        try{
            return memberDao.deleteMember(id);
        }catch (Exception e){
            throw new BaseException(FAILED_TO_MEMBER);
        }
    }

    public int insertMember(PostMemberRes member) {
        return memberDao.insertMember(member);
    }
}

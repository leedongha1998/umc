package com.example.demo.src.member;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.member.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;
import static com.example.demo.config.validation.Validation.checkPhone;


@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원 정보 확인
     */
    @ResponseBody
    @GetMapping("/{id}")
    public BaseResponse<GetMemberInfoRes> findMemberInfoById(@PathVariable Long id){

        try{
            GetMemberInfoRes findMember = memberService.findMemberInfoById(id);
            return new BaseResponse<>(findMember);
        }catch (BaseException e){
            return new BaseResponse<>(FAILED_TO_MEMBER);
        }
    }

    /**
     * 회원가입
     *
     */
    @ResponseBody
    @PostMapping("/{id}")
    public BaseResponse<String> insertMember(@PathVariable long id, @RequestBody PostMemberRes member){
        PostMemberRes postMemberRes = new PostMemberRes(id,member.getPassword(), member.getEmail(), member.getStatus(), member.getTemp(), member.getPhone());
        memberService.insertMember(postMemberRes);
        String result = "";
        return new BaseResponse<>(result);
    }

    /**
     * 회원 정보 수정
     */
    @ResponseBody
    @PatchMapping("/{id}")
    public BaseResponse<String> updateMember(@PathVariable Long id, @RequestBody Member member){
        if(member.getEmail() == null){
            return new BaseResponse<>(POST_USERS_EMPTY_EMAIL);
        }

        if(!checkPhone(member.getPhone())){
            return new BaseResponse<>(FAILED_TO_PHONE);
        }

        try{
            PatchMemberReq patchMemberReq = new PatchMemberReq(id,member.getPassword(), member.getEmail(), member.getStatus(), member.getTemp(), member.getPhone());
            memberService.updateMember(patchMemberReq);
            String result = "";
            return new BaseResponse<>(result);
        }catch (BaseException e){
            return new BaseResponse<>(FAILED_TO_MEMBER);
        }
    }

    /**
     * 회원 정보 삭제
     *
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public BaseResponse<String> deleteMember(@PathVariable long id){
        try {
            memberService.deleteMember(id);
            String result = "";
            return new BaseResponse<>(result);
        } catch (BaseException e) {
            return new BaseResponse<>(FAILED_TO_MEMBER);
        }
    }

    /**
     * 회원 뱃지 리스트
     */
    @ResponseBody
    @GetMapping("/{id}/badges")
    public BaseResponse<List<GetMemberBadgeRes>> findBadgeList(@PathVariable Long id) throws BaseException {
       try{
            List<GetMemberBadgeRes> findBadges = memberService.findBadgeList(id);
            return new BaseResponse<>(findBadges);
       }catch (BaseException e){
           return new BaseResponse<>(FAILED_TO_BADGE);
       }
    }

    /**
     * 내가 판매중인 상품 확인
     */
    @ResponseBody
    @GetMapping("/{id}/product")
    public BaseResponse<List<GetMemberProduct>> findMyProductList(@PathVariable long id){
        try{
            List<GetMemberProduct> products = memberService.findProductList(id);
            return new BaseResponse<>(products);
        }catch (BaseException e){
            return new BaseResponse<>(FAILED_TO_PRODUCT);
        }
    }



}

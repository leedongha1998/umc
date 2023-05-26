package com.example.demo.src.activity;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.activity.model.GetActivityRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;
    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    /**
     * 동네생활 리스트
     * @return
     */
    @ResponseBody
    @GetMapping()
    public BaseResponse<List<GetActivityRes>> getActivityList(){

        List<GetActivityRes> list = activityService.getActvityList();

        return new BaseResponse<>(list);
    }
}

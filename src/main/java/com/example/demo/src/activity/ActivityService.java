package com.example.demo.src.activity;

import com.example.demo.src.activity.model.GetActivityRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityDao activityDao;

    @Autowired
    public ActivityService(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    public List<GetActivityRes> getActvityList() {
        return activityDao.getActivityList();
    }
}

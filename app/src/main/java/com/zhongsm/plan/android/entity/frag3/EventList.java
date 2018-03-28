package com.zhongsm.plan.android.entity.frag3;

import com.zhongsm.android.BaseVo;

import java.util.List;

/**
 * Created by ThinkPad S5-WangJ on 2018/3/24.
 */

public class EventList extends BaseVo {
    private String error_code;
    private String reason;
    private List<SimpleEventVo> result; //

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<SimpleEventVo> getResult() {
        return result;
    }

    public void setResult(List<SimpleEventVo> result) {
        this.result = result;
    }

    /**
     * 内部类
     */
    public static class SimpleEventVo {
        private String day;
        private String date;
        private String title;
        private String e_id;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getE_id() {
            return e_id;
        }

        public void setE_id(String e_id) {
            this.e_id = e_id;
        }
    }
}

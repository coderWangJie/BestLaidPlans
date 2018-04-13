package com.zhongsm.plan.android.entity.historytoday;

import com.zhongsm.android.BaseVo;

import java.util.List;

/**
 * Created by ThinkPad S5-WangJ on 2018/3/24.
 */

public class EventDetialVo extends BaseVo {
    private String error_code;
    private String reason;
    private List<EventVo> result; //

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

    public List<EventVo> getResult() {
        return result;
    }

    public void setResult(List<EventVo> result) {
        this.result = result;
    }

    public static class EventVo {
        private String e_id; // 事件ID
        private String content; // 事件详情
        private String picNo; // 图片数量
        private String title;  // 事件标题
        private List<PictureVo> picUrl; // 图片地址

        public String getE_id() {
            return e_id;
        }

        public void setE_id(String e_id) {
            this.e_id = e_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPicNo() {
            return picNo;
        }

        public void setPicNo(String picNo) {
            this.picNo = picNo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<PictureVo> getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(List<PictureVo> picUrl) {
            this.picUrl = picUrl;
        }
    }

    public static class PictureVo {
        private String url; // 图片地址
        private String pic_title; // 图片标题
        private String id; // 图片ID(顺序)

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPic_title() {
            return pic_title;
        }

        public void setPic_title(String pic_title) {
            this.pic_title = pic_title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

}

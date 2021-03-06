package com.ton2xmania.mvppractice.model;

import java.util.List;

/**
 * Created by ton2xmania on 04/11/16.
 */

public class CountryModel {
    private RestResponseBean RestResponse;

    public RestResponseBean getRestResponse() {
        return RestResponse;
    }

    public void setRestResponse(RestResponseBean RestResponse) {
        this.RestResponse = RestResponse;
    }

    public static class RestResponseBean {
        private List<String> messages;
        private List<ResultBean> result;

        public List<String> getMessages() {
            return messages;
        }

        public void setMessages(List<String> messages) {
            this.messages = messages;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            private String name;
            private String alpha2_code;
            private String alpha3_code;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlpha2_code() {
                return alpha2_code;
            }

            public void setAlpha2_code(String alpha2_code) {
                this.alpha2_code = alpha2_code;
            }

            public String getAlpha3_code() {
                return alpha3_code;
            }

            public void setAlpha3_code(String alpha3_code) {
                this.alpha3_code = alpha3_code;
            }
        }
    }
}

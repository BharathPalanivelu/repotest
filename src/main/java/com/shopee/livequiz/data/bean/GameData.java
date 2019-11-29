package com.shopee.livequiz.data.bean;

import com.shopee.sdk.b.a;
import java.util.ArrayList;
import java.util.List;

public class GameData extends a {
    public static final String TYPE_ANSWER = "answer";
    public static final String TYPE_END_LIVE = "end_live";
    public static final String TYPE_HIDE_RESULT = "hide_result";
    public static final String TYPE_QUEATION = "question";
    public static final String TYPE_SESSION_RESULT = "session_result";
    public MSgBody msg_body;
    public String msg_type;

    public static class MSgBody {
        public String answer_text = "";
        public List<AnswerBean> answers = new ArrayList();
        public int correct_answer_id;
        public float each_coins;
        public int question_id;
        public String question_text = "";
        public int sn;
        public long timestamp;
        public int winners;

        public static class AnswerBean {
            public int answer_id;
            public String answer_text;
            public int users;

            public AnswerBean(int i, String str) {
                this.answer_id = i;
                this.answer_text = str;
            }

            public AnswerBean(int i, int i2, String str) {
                this.users = i;
                this.answer_id = i2;
                this.answer_text = str;
            }
        }
    }

    public String toString() {
        return this.msg_type + ", " + this.msg_body.question_text;
    }
}

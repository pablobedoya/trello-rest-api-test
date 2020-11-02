package com.trello.restapi.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CardResponse {
    public String id;
    public List<String> checkItemStates;
    public Boolean closed;
    public Date dateLastActivity;
    public String desc;
    public DescData descData;
    public String dueReminder;
    public String idBoard;
    public String idList;
    public List<String> idMembersVoted;
    public Integer idShort;
    public String idAttachmentCover;
    public List<String> idLabels;
    public Boolean manualCoverAttachment;
    public String name;
    public Integer pos;
    public String shortLink;
    public Boolean isTemplate;
    public Boolean dueComplete;
    public String due;
    public List<String> labels;
    public String shortUrl;
    public String start;
    public String url;
    public Cover cover;
    public List<String> idMembers;
    public String email;
    public Badges badges;
    public Boolean subscribed;
    public List<String> idChecklists;
    public List<String> attachments;
    public List<String> stickers;
    public Limits limits;
}

@Getter
@Setter
class Emoji {
}

@Getter
@Setter
class DescData {
    public Emoji emoji;
}

@Getter
@Setter
class Cover {
    public String idAttachment;
    public String color;
    public String idUploadedBackground;
    public String size;
    public String brightness;
}

@Getter
@Setter
class Trello {
    public Integer board;
    public Integer card;
}

@Getter
@Setter
class AttachmentsByType {
    public Trello trello;
}

@Getter
@Setter
class Badges {
    public AttachmentsByType attachmentsByType;
    public Boolean location;
    public Integer votes;
    public Boolean viewingMemberVoted;
    public Boolean subscribed;
    public String fogbugz;
    public Integer checkItems;
    public Integer checkItemsChecked;
    public String checkItemsEarliestDue;
    public Integer comments;
    public Integer attachments;
    public Boolean description;
    public String due;
    public Boolean dueComplete;
    public String start;
}

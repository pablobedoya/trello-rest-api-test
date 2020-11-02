package com.trello.restapi.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBoardResponse {
    public String id;
    public String name;
    public String desc;
    public String descData;
    public Boolean closed;
    public String idOrganization;
    public String idEnterprise;
    public Boolean pinned;
    public String url;
    public String shortUrl;
    public Prefs prefs;
    public LabelNames labelNames;
    public Limits limits;
}

@Getter
@Setter
class Prefs {
    public String permissionLevel;
    public Boolean hideVotes;
    public String voting;
    public String comments;
    public String invitations;
    public Boolean selfJoin;
    public Boolean cardCovers;
    public Boolean isTemplate;
    public String cardAging;
    public Boolean calendarFeedEnabled;
    public String background;
    public String backgroundImage;
    public String backgroundImageScaled;
    public Boolean backgroundTile;
    public String backgroundBrightness;
    public String backgroundColor;
    public String backgroundBottomColor;
    public String backgroundTopColor;
    public Boolean canBePublic;
    public Boolean canBeEnterprise;
    public Boolean canBeOrg;
    public Boolean canBePrivate;
    public Boolean canInvite;
}

@Getter
@Setter
class LabelNames {
    public String green;
    public String yellow;
    public String orange;
    public String red;
    public String purple;
    public String blue;
    public String sky;
    public String lime;
    public String pink;
    public String black;
}

@Getter
@Setter
class Limits {
}

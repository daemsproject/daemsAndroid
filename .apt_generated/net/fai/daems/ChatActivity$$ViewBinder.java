// Generated code from Butter Knife. Do not modify!
package net.fai.daems;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ChatActivity$$ViewBinder<T extends net.fai.daems.ChatActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296256, "field 'tvName'");
    target.tvName = finder.castView(view, 2131296256, "field 'tvName'");
    view = finder.findRequiredView(source, 2131296262, "field 'iBtnBack'");
    target.iBtnBack = finder.castView(view, 2131296262, "field 'iBtnBack'");
    view = finder.findRequiredView(source, 2131296276, "field 'etInput'");
    target.etInput = finder.castView(view, 2131296276, "field 'etInput'");
    view = finder.findRequiredView(source, 2131296279, "field 'lvChatRecord'");
    target.lvChatRecord = finder.castView(view, 2131296279, "field 'lvChatRecord'");
    view = finder.findRequiredView(source, 2131296278, "field 'btnSend'");
    target.btnSend = finder.castView(view, 2131296278, "field 'btnSend'");
  }

  @Override public void unbind(T target) {
    target.tvName = null;
    target.iBtnBack = null;
    target.etInput = null;
    target.lvChatRecord = null;
    target.btnSend = null;
  }
}

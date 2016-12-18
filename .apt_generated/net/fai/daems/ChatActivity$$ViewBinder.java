// Generated code from Butter Knife. Do not modify!
package net.fai.daems;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ChatActivity$$ViewBinder<T extends net.fai.daems.ChatActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230740, "field 'lvChatRecord'");
    target.lvChatRecord = finder.castView(view, 2131230740, "field 'lvChatRecord'");
    view = finder.findRequiredView(source, 2131230723, "field 'iBtnBack'");
    target.iBtnBack = finder.castView(view, 2131230723, "field 'iBtnBack'");
    view = finder.findRequiredView(source, 2131230737, "field 'etInput'");
    target.etInput = finder.castView(view, 2131230737, "field 'etInput'");
    view = finder.findRequiredView(source, 2131230739, "field 'btnSend'");
    target.btnSend = finder.castView(view, 2131230739, "field 'btnSend'");
    view = finder.findRequiredView(source, 2131230720, "field 'tvName'");
    target.tvName = finder.castView(view, 2131230720, "field 'tvName'");
  }

  @Override public void unbind(T target) {
    target.lvChatRecord = null;
    target.iBtnBack = null;
    target.etInput = null;
    target.btnSend = null;
    target.tvName = null;
  }
}

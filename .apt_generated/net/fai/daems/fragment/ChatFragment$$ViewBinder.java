// Generated code from Butter Knife. Do not modify!
package net.fai.daems.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ChatFragment$$ViewBinder<T extends net.fai.daems.fragment.ChatFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230741, "field 'lvChat'");
    target.lvChat = finder.castView(view, 2131230741, "field 'lvChat'");
  }

  @Override public void unbind(T target) {
    target.lvChat = null;
  }
}

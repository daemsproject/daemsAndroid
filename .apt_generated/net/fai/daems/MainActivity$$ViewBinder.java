// Generated code from Butter Knife. Do not modify!
package net.fai.daems;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends net.fai.daems.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296268, "field 'rbChat'");
    target.rbChat = finder.castView(view, 2131296268, "field 'rbChat'");
    view = finder.findRequiredView(source, 2131296267, "field 'rpTab'");
    target.rpTab = finder.castView(view, 2131296267, "field 'rpTab'");
    view = finder.findRequiredView(source, 2131296265, "field 'tvTopbar'");
    target.tvTopbar = finder.castView(view, 2131296265, "field 'tvTopbar'");
    view = finder.findRequiredView(source, 2131296266, "field 'btnTopbar'");
    target.btnTopbar = finder.castView(view, 2131296266, "field 'btnTopbar'");
  }

  @Override public void unbind(T target) {
    target.rbChat = null;
    target.rpTab = null;
    target.tvTopbar = null;
    target.btnTopbar = null;
  }
}

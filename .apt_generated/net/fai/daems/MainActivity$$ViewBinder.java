// Generated code from Butter Knife. Do not modify!
package net.fai.daems;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends net.fai.daems.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230726, "field 'tvTopbar'");
    target.tvTopbar = finder.castView(view, 2131230726, "field 'tvTopbar'");
    view = finder.findRequiredView(source, 2131230727, "field 'btnTopbar'");
    target.btnTopbar = finder.castView(view, 2131230727, "field 'btnTopbar'");
    view = finder.findRequiredView(source, 2131230728, "field 'rpTab'");
    target.rpTab = finder.castView(view, 2131230728, "field 'rpTab'");
    view = finder.findRequiredView(source, 2131230729, "field 'rbChat'");
    target.rbChat = finder.castView(view, 2131230729, "field 'rbChat'");
  }

  @Override public void unbind(T target) {
    target.tvTopbar = null;
    target.btnTopbar = null;
    target.rpTab = null;
    target.rbChat = null;
  }
}

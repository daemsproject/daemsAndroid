// Generated code from Butter Knife. Do not modify!
package net.fai.daems;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AccountActivity$$ViewBinder<T extends net.fai.daems.AccountActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230724, "field 'btnAdd' and method 'onClick'");
    target.btnAdd = finder.castView(view, 2131230724, "field 'btnAdd'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131230723, "field 'btnBack' and method 'onClick'");
    target.btnBack = finder.castView(view, 2131230723, "field 'btnBack'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131230725, "field 'lvAccount'");
    target.lvAccount = finder.castView(view, 2131230725, "field 'lvAccount'");
  }

  @Override public void unbind(T target) {
    target.btnAdd = null;
    target.btnBack = null;
    target.lvAccount = null;
  }
}

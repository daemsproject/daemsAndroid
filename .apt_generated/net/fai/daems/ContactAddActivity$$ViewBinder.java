// Generated code from Butter Knife. Do not modify!
package net.fai.daems;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ContactAddActivity$$ViewBinder<T extends net.fai.daems.ContactAddActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230737, "field 'etInput'");
    target.etInput = finder.castView(view, 2131230737, "field 'etInput'");
    view = finder.findRequiredView(source, 2131230724, "field 'btnAdd'");
    target.btnAdd = finder.castView(view, 2131230724, "field 'btnAdd'");
  }

  @Override public void unbind(T target) {
    target.etInput = null;
    target.btnAdd = null;
  }
}

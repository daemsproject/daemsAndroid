// Generated code from Butter Knife. Do not modify!
package net.fai.daems.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ContactFragment$$ViewBinder<T extends net.fai.daems.fragment.ContactFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230748, "field 'btnSwitch'");
    target.btnSwitch = finder.castView(view, 2131230748, "field 'btnSwitch'");
    view = finder.findRequiredView(source, 2131230750, "field 'lvContact'");
    target.lvContact = finder.castView(view, 2131230750, "field 'lvContact'");
  }

  @Override public void unbind(T target) {
    target.btnSwitch = null;
    target.lvContact = null;
  }
}

KeyTextView
===========

Android带动作关键字的TextView

通过继承ClickableSpan，给TextView添加事件

依次调用
KeyTextView.recycle();//清除，KeyTextView中的内容，在ListView或需要重复利用控件时调用


KeyTextView.addStr("赞了你的作品",newIntent());//重复调用，文字内容通过本方法拼接，参数1为显示的文字，参数2为跳转的Intent，可以为空，即为普通文字。


KeyTextView.show();//最后调用显示

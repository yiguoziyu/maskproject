package com.ljj.maskproject.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.IntDef;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;


import com.ljj.maskproject.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class StateLayout extends FrameLayout {

    public static final int VIEW_STATE_UNKNOWN = -1;

    public static final int VIEW_STATE_CONTENT = 0;

    public static final int VIEW_STATE_ERROR = 1;

    public static final int VIEW_STATE_EMPTY = 2;

    public static final int VIEW_STATE_LOADING = 3;

    public void showContentView() {
        setViewState(VIEW_STATE_CONTENT);
    }

    public void showProgressView() {
        setViewState(VIEW_STATE_LOADING);
    }
    public void showEmptyView() {
        setViewState(VIEW_STATE_EMPTY);
    }

    public void showErrorView() {
        setViewState(VIEW_STATE_ERROR);
    }

    public void setErrorAction(final OnClickListener onErrorButtonClickListener) {
        mErrorView.setOnClickListener(onErrorButtonClickListener);
    }

    public void setEmptyAction(final OnClickListener onEmptyButtonClickListener) {
        mEmptyView.setOnClickListener(onEmptyButtonClickListener);
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({VIEW_STATE_UNKNOWN, VIEW_STATE_CONTENT, VIEW_STATE_ERROR, VIEW_STATE_EMPTY, VIEW_STATE_LOADING})
    public @interface ViewState {
    }

    private LayoutInflater mInflater;

    private View mContentView;

    private View mLoadingView;

    private View mErrorView;

    private View mEmptyView;

    private boolean mAnimateViewChanges = false;

    @ViewState
    private int mViewState = VIEW_STATE_UNKNOWN;

    public StateLayout(Context context) {
        this(context, null);
    }

    public StateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public StateLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mInflater = LayoutInflater.from(getContext());
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.StateLayout);

        int loadingViewResId = a.getResourceId(R.styleable.StateLayout_msv_loadingView, R.layout.view_progress);
        if (loadingViewResId > -1) {
            mLoadingView = mInflater.inflate(loadingViewResId, this, false);
            addView(mLoadingView, mLoadingView.getLayoutParams());
        }

        int emptyViewResId = a.getResourceId(R.styleable.StateLayout_msv_emptyView, R.layout.view_empty);
        if (emptyViewResId > -1) {
            mEmptyView = mInflater.inflate(emptyViewResId, this, false);
            addView(mEmptyView, mEmptyView.getLayoutParams());
        }

        int errorViewResId = a.getResourceId(R.styleable.StateLayout_msv_errorView, R.layout.view_error);
        if (errorViewResId > -1) {
            mErrorView = mInflater.inflate(errorViewResId, this, false);
            addView(mErrorView, mErrorView.getLayoutParams());
        }

        int viewState = a.getInt(R.styleable.StateLayout_msv_viewState, VIEW_STATE_LOADING);
        mAnimateViewChanges = a.getBoolean(R.styleable.StateLayout_msv_animateViewChanges, true);

        switch (viewState) {
            case VIEW_STATE_CONTENT:
                mViewState = VIEW_STATE_CONTENT;
                break;

            case VIEW_STATE_ERROR:
                mViewState = VIEW_STATE_ERROR;
                break;

            case VIEW_STATE_EMPTY:
                mViewState = VIEW_STATE_EMPTY;
                break;

            case VIEW_STATE_LOADING:
                mViewState = VIEW_STATE_LOADING;
                break;

            case VIEW_STATE_UNKNOWN:
            default:
                mViewState = VIEW_STATE_UNKNOWN;
                break;
        }
        a.recycle();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mContentView == null) throw new IllegalArgumentException("Content view is not defined");
        //boolean temp=mAnimateViewChanges;
        //mAnimateViewChanges=false;
        setView(VIEW_STATE_UNKNOWN);
        //mAnimateViewChanges=temp;
    }

    /* All of the addView methods have been overridden so that it can obtain the content view via XML
     It is NOT recommended to add views into MultiStateView via the addView methods, but rather use
     any of the setViewForState methods to set views for their given ViewState accordingly */
    @Override
    public void addView(View child) {
        if (isValidContentView(child)) mContentView = child;
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        if (isValidContentView(child)) mContentView = child;
        super.addView(child, index);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (isValidContentView(child)) mContentView = child;
        super.addView(child, index, params);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (isValidContentView(child)) mContentView = child;
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int width, int height) {
        if (isValidContentView(child)) mContentView = child;
        super.addView(child, width, height);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        if (isValidContentView(child)) mContentView = child;
        return super.addViewInLayout(child, index, params);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        if (isValidContentView(child)) mContentView = child;
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }

    @Nullable
    public View getView(@ViewState int state) {
        switch (state) {
            case VIEW_STATE_LOADING:
                return mLoadingView;

            case VIEW_STATE_CONTENT:
                return mContentView;

            case VIEW_STATE_EMPTY:
                return mEmptyView;

            case VIEW_STATE_ERROR:
                return mErrorView;

            default:
                return null;
        }
    }


    @ViewState
    public int getViewState() {
        return mViewState;
    }


    public void setViewState(@ViewState int state) {
        if (state != mViewState) {
            int previous = mViewState;
            mViewState = state;
            setView(previous);
        }
    }


    private void setView(@ViewState int previousState) {
        switch (mViewState) {
            case VIEW_STATE_LOADING:
                if (mLoadingView == null) {
                    throw new NullPointerException("Loading View");
                }

                if (mContentView != null) mContentView.setVisibility(View.GONE);
                if (mErrorView != null) mErrorView.setVisibility(View.GONE);
                if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
                if(mLoadingView.getVisibility()==VISIBLE)return;
                if (mAnimateViewChanges) {
                    animateLayoutChange(getView(previousState));
                } else {
                    mLoadingView.setVisibility(View.VISIBLE);
                }
                break;

            case VIEW_STATE_EMPTY:
                if (mEmptyView == null) {
                    throw new NullPointerException("Empty View");
                }


                if (mLoadingView != null) mLoadingView.setVisibility(View.GONE);
                if (mErrorView != null) mErrorView.setVisibility(View.GONE);
                if (mContentView != null) mContentView.setVisibility(View.GONE);
                if(mEmptyView.getVisibility()==VISIBLE)return;
                if (mAnimateViewChanges) {
                    animateLayoutChange(getView(previousState));
                } else {
                    mEmptyView.setVisibility(View.VISIBLE);
                }
                break;

            case VIEW_STATE_ERROR:
                if (mErrorView == null) {
                    throw new NullPointerException("Error View");
                }


                if (mLoadingView != null) mLoadingView.setVisibility(View.GONE);
                if (mContentView != null) mContentView.setVisibility(View.GONE);
                if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
                if(mErrorView.getVisibility()==VISIBLE)return;
                if (mAnimateViewChanges) {
                    animateLayoutChange(getView(previousState));
                } else {
                    mErrorView.setVisibility(View.VISIBLE);
                }
                break;

            case VIEW_STATE_CONTENT:
            default:
                if (mContentView == null) {
                    // Should never happen, the view should throw an exception if no content view is present upon creation
                    throw new NullPointerException("Content View");
                }


                if (mLoadingView != null) mLoadingView.setVisibility(View.GONE);
                if (mErrorView != null) mErrorView.setVisibility(View.GONE);
                if (mEmptyView != null) mEmptyView.setVisibility(View.GONE);
                if(mContentView.getVisibility()==VISIBLE)return;
                if (mAnimateViewChanges) {
                    animateLayoutChange(getView(previousState));
                } else {
                    mContentView.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    /**
     * Checks if the given {@link View} is valid for the Content View
     *
     * @param view The {@link View} to check
     * @return
     */
    private boolean isValidContentView(View view) {
        if (mContentView != null && mContentView != view) {
            return false;
        }

        return view != mLoadingView && view != mErrorView && view != mEmptyView;
    }
    public void setViewbefor()
    {
        if (mLoadingView != null) removeView(mLoadingView);
        if (mEmptyView != null) removeView(mEmptyView);
        if (mErrorView != null) removeView(mErrorView);
        if (mContentView != null) removeView(mContentView);
        addView(mContentView);
        addView(mEmptyView);
        addView(mErrorView);
        addView(mLoadingView);
    }

    public void setViewForState(View view, @ViewState int state, boolean switchToState) {
        switch (state) {
            case VIEW_STATE_LOADING:
                if (mLoadingView != null) removeView(mLoadingView);
                mLoadingView = view;
                addView(mLoadingView);
                break;

            case VIEW_STATE_EMPTY:
                if (mEmptyView != null) removeView(mEmptyView);
                mEmptyView = view;
                addView(mEmptyView);
                break;

            case VIEW_STATE_ERROR:
                if (mErrorView != null) removeView(mErrorView);
                mErrorView = view;
                addView(mErrorView);
                break;

            case VIEW_STATE_CONTENT:
                if (mContentView != null) removeView(mContentView);
                mContentView = view;
                addView(mContentView);
                break;
        }

        setView(VIEW_STATE_UNKNOWN);
        if (switchToState) setViewState(state);
    }

    public void setViewForState(View view, @ViewState int state) {
        setViewForState(view, state, false);
    }


    public void setViewForState(@LayoutRes int layoutRes, @ViewState int state, boolean switchToState) {
        if (mInflater == null) mInflater = LayoutInflater.from(getContext());
        View view = mInflater.inflate(layoutRes, this, false);
        setViewForState(view, state, switchToState);
    }


    public void setViewForState(@LayoutRes int layoutRes, @ViewState int state) {
        setViewForState(layoutRes, state, false);
    }

    /**
     * Sets whether an animate will occur when changing between {@link ViewState}
     *
     * @param animate
     */
    public void setAnimateLayoutChanges(boolean animate) {
        mAnimateViewChanges = animate;
    }

    /**
     * Animates the layout changes between {@link ViewState}
     *
     * @param previousView The view that it was currently on
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void animateLayoutChange(@Nullable final View previousView) {
        if (previousView == null) {
            getView(mViewState).setVisibility(View.VISIBLE);
            return;
        }

        previousView.setVisibility(View.VISIBLE);
        ObjectAnimator anim = ObjectAnimator.ofFloat(previousView, "alpha", 1.0f, 0.0f).setDuration(250L);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                previousView.setVisibility(View.GONE);
                getView(mViewState).setVisibility(View.VISIBLE);
                ObjectAnimator.ofFloat(getView(mViewState), "alpha", 0.0f, 1.0f).setDuration(250L).start();
            }
        });
        anim.start();
        mContentView.setVisibility(View.GONE);
    }
}

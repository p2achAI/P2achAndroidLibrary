package ai.p2ach.p2achandroidlibrary.base.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/*
* BaseActivity와 마찬가지로 선언된 VB를 자동으로 inflate하여 자식에서의 Boilerplate Code 방지
* */

abstract class BaseFragment<VB : ViewBinding>: Fragment() {

    private var fragmentBinding: VB? = null
    protected val _fragmentBinding get() = fragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (fragmentBinding == null) {
            val vbClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VB>
            val inflateMethod = vbClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
            fragmentBinding = inflateMethod.invoke(null, inflater, container, false) as VB
        }
        return fragmentBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewInit(savedInstanceState)
    }

    open fun viewInit(savedInstanceState: Bundle?){}
}
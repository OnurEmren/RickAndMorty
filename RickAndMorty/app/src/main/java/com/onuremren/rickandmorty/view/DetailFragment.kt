package com.onuremren.rickandmorty.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.onuremren.rickandmorty.R
import com.onuremren.rickandmorty.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {



    private lateinit var dataBinding: FragmentDetailBinding
    private var characterId = 0
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val character = args.info
        val chrId = args.navId
        val location = args.location

        arguments?.let {
            characterId= DetailFragmentArgs.fromBundle(it).navId

        }

        dataBinding.selectedChar = character
        Glide.with(this).load(character.image).into(charImage)
        dataBinding.selectedLocation = location

        /*
        statusTv.text= character.status
        nameText.text= character.name
        specieTv.text = character.species
        genderTv.text = character.gender
        episodeTV.text = character.episode.size.toString()
        originText.text= character.origin.name
        locationTv.text= character.location.name
        Glide.with(this).load(character.image).into(charImage)

        <TextView
                android:id="@+id/TvEpisode"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="19dp"
                android:textSize="18sp"
                android:textStyle="bold"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="1.0"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="@+id/episodeTV"
                tools:text="@{selectedChar.episode}" />

         */

    }
}
package com.example.contacts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.model.Message
import com.squareup.picasso.Picasso

class RecyclerMessageListAdapter(val context: Context, val messages: List<Any>):
RecyclerView.Adapter<RecyclerMessageListAdapter.BaseViewHolder<*>>() {
    private val VIEW_TYPE_MESSAGE_SENT = 1
    private val VIEW_TYPE_MESSAGE_RECEIVED = 2

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            VIEW_TYPE_MESSAGE_SENT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_message_layout, parent, false)
                SentMessageHolder(view)
            }
            VIEW_TYPE_MESSAGE_RECEIVED -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_message_dest_layout, parent, false)
                ReceivedMessageHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type!")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val message = messages.get(position) as Message
        when (holder) {
            is SentMessageHolder -> holder.bind(message)
            is ReceivedMessageHolder -> holder.bind(message)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = messages.size

    class SentMessageHolder(itemView: View) : BaseViewHolder<Message>(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.text_gchat_message_me)
        val timeText: TextView = itemView.findViewById(R.id.text_gchat_date_me)

        override fun bind(message: Message) {
            messageText.text = message.message
            // Format the stored timestamp into a readable String using method.
            //timeText.setText(Utils.formatDateTime(message.getCreatedAt()));
        }
    }

    class ReceivedMessageHolder(itemView: View) : BaseViewHolder<Message>(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.text_gchat_message_other);
        val timeText: TextView = itemView.findViewById(R.id.text_gchat_timestamp_other);
        val nameText: TextView = itemView.findViewById(R.id.text_gchat_user_other);
        val profileImage: ImageView = itemView.findViewById(R.id.image_gchat_profile_other);

        override fun bind(message: Message) {
            messageText.text = message.message
            nameText.text = message.sender.nickname

            // Format the stored timestamp into a readable String using method.
            //timeText.setText(Utils.formatDateTime(message.getCreatedAt()));

            // Insert the profile image from the URL into the ImageView.
            Picasso.get().load(message.sender.profileURL).into(profileImage)
        }
    }
}
package hiiragi283.material.network

import hiiragi283.material.util.readBlockPos
import hiiragi283.material.util.readNBTTag
import hiiragi283.material.util.writeBlockPos
import hiiragi283.material.util.writeNBTTag
import io.netty.buffer.ByteBuf
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.math.BlockPos
import net.minecraftforge.fml.common.network.simpleimpl.IMessage

sealed class HiiragiMessage(var pos: BlockPos = BlockPos.ORIGIN) : IMessage {

    override fun fromBytes(buf: ByteBuf) {
        pos = buf.readBlockPos()
    }

    override fun toBytes(buf: ByteBuf) {
        buf.writeBlockPos(pos)
    }

    class ToClient(pos: BlockPos = BlockPos.ORIGIN, var tag: NBTTagCompound = NBTTagCompound()) : HiiragiMessage(pos) {

        override fun fromBytes(buf: ByteBuf) {
            super.fromBytes(buf)
            tag = buf.readNBTTag() ?: NBTTagCompound()
        }

        override fun toBytes(buf: ByteBuf) {
            super.toBytes(buf)
            buf.writeNBTTag(tag)
        }

    }

}
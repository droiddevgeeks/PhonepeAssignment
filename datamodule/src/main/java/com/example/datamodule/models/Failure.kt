package com.example.datamodule.models

import com.example.domainmodule.common.ErrorModel
import com.example.domainmodule.common.IFailure


sealed class Failure(override val errorModel: ErrorModel) : IFailure {
    class HttpError(error: ErrorModel) : Failure(error)
    class DisplayableError(error: ErrorModel) : Failure(error)
}
